/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package org.customer.feedback.service.impl;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.security.auth.AuthenticationService;
import de.hybris.platform.servicelayer.security.auth.InvalidCredentialsException;
import de.hybris.platform.servicelayer.user.UserService;

import java.util.stream.IntStream;

import javax.annotation.Resource;

import org.customer.feedback.data.CustomerFeedbackReviewData;
import org.customer.feedback.exception.MaximumFeedbackExceedException;
import org.customer.feedback.model.CustomerFeedbackReviewModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.access.AccessDeniedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;


@IntegrationTest
public class DefaultCustomerFeedbackServiceIntegrationTest extends ServicelayerBaseTest
{
	private static final String TEST_USER_ID = "testUser";
	private static final String TEST_USER_PASSWORD = "testUserPWD";
	private static final String LANG_ISO_CODE = "en";
	private static final String REVIEW_TITLE = "title";
	private static final String REVIEW_CONTENT = "content";
	private static final int LIMITED_FEEDBACK_REVIEWS_PER_CUSTOMER = 5;


	@Resource
	private DefaultCustomerFeedbackService customerFeedbackService;

	@Resource
	private CommonI18NService commonI18NService;

	@Resource
	private ConfigurationService configurationService;

	@Resource
	private ModelService modelService;

	@Resource
	private UserService userService;

	@Resource
	private AuthenticationService authenticationService;

	private UserModel testUser;
	private CustomerFeedbackReviewData customerFeedbackReviewData;

	@Before
	public void setUp() throws Exception
	{
		testUser = modelService.create(UserModel.class);
		testUser.setUid(TEST_USER_ID);
		modelService.save(testUser);
		userService.setPassword(TEST_USER_ID, TEST_USER_PASSWORD);

		customerFeedbackReviewData = new CustomerFeedbackReviewData();
		customerFeedbackReviewData.setContent(REVIEW_CONTENT);
		customerFeedbackReviewData.setTitle(REVIEW_TITLE);
		customerFeedbackReviewData.setLang(LANG_ISO_CODE);
	}

	@Test(expected = AccessDeniedException.class)
	public void testCreateCustomerFeedbackReview_noLoggedInUser()
	{
		customerFeedbackService.addCustomerFeedbackReview(customerFeedbackReviewData);

		fail("No current user found");
	}

	@Test(expected = UnknownIdentifierException.class)
	public void testCreateCustomerFeedbackReview_invalidLang() throws InvalidCredentialsException
	{
		customerFeedbackReviewData.setLang("fxxx");
		authenticationService.login(TEST_USER_ID, TEST_USER_PASSWORD);
		customerFeedbackService.addCustomerFeedbackReview(customerFeedbackReviewData);

		fail("Invalid language provided");
	}

	@Test(expected = MaximumFeedbackExceedException.class)
	public void testCreateCustomerFeedbackReview_maxFeedbacksExceeded() throws InvalidCredentialsException
	{
		authenticationService.login(TEST_USER_ID, TEST_USER_PASSWORD);
		configurationService.getConfiguration().setProperty(DefaultCustomerFeedbackService.MAX_FEEDBACK_PER_CUSTOMER_CONFIG_KEY,
				String.valueOf(LIMITED_FEEDBACK_REVIEWS_PER_CUSTOMER));
		createFeedbacksToExceedMaxCount();
		customerFeedbackService.addCustomerFeedbackReview(customerFeedbackReviewData);

		fail("Maximum number of feedbacks exceeded");
	}

	@Test
	public void testCreateCustomerFeedbackReview() throws InvalidCredentialsException
	{
		authenticationService.login(TEST_USER_ID, TEST_USER_PASSWORD);

		CustomerFeedbackReviewModel model = customerFeedbackService.addCustomerFeedbackReview(customerFeedbackReviewData);
		modelService.refresh(model);

		assertNotNull(model.getPk());
		assertEquals(model.getTitle(), REVIEW_TITLE);
		assertEquals(model.getTitle(), REVIEW_TITLE);
	}

	private void createFeedbacksToExceedMaxCount()
	{
		IntStream.range(0, LIMITED_FEEDBACK_REVIEWS_PER_CUSTOMER).forEach(
				index -> {
					CustomerFeedbackReviewModel model = modelService.create(CustomerFeedbackReviewModel.class);
					model.setUser(testUser);
					model.setLanguage(commonI18NService.getLanguage(LANG_ISO_CODE));
					model.setContent(REVIEW_CONTENT + index);
					model.setTitle(REVIEW_TITLE + index);
					modelService.save(model);
				}
		);
	}

}
