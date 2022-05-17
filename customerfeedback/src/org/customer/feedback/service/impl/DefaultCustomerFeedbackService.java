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

import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import org.customer.feedback.data.CustomerFeedbackReviewData;

import java.util.List;

import javax.ws.rs.BadRequestException;

import org.customer.feedback.dao.CustomerFeedbackReviewDao;
import org.customer.feedback.exception.MaximumFeedbackExceedException;
import org.customer.feedback.model.CustomerFeedbackReviewModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import org.customer.feedback.service.CustomerFeedbackService;
import org.springframework.security.access.AccessDeniedException;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNull;
import static org.customer.feedback.constants.CustomerfeedbackConstants.MAX_FEEDBACK_PER_CUSTOMER;


public class DefaultCustomerFeedbackService implements CustomerFeedbackService
{
	private static final Logger LOG = LoggerFactory.getLogger(DefaultCustomerFeedbackService.class);
	protected static final String MAX_FEEDBACK_PER_CUSTOMER_CONFIG_KEY = "customerfeedback.max.feedback.per.user";

	private ConfigurationService configurationService;
	private CustomerFeedbackReviewDao customerFeedbackReviewDao;
	private ModelService modelService;
	private UserService userService;
	private Populator<CustomerFeedbackReviewData, CustomerFeedbackReviewModel> customerFeedbackReviewReversePopulator;

	@Override
	public CustomerFeedbackReviewModel addCustomerFeedbackReview(CustomerFeedbackReviewData customerFeedbackReviewData)
	{
		UserModel currentUser = getUserService().getCurrentUser();
		if (currentUser == null || getUserService().isAnonymousUser(currentUser)) {
			throw new AccessDeniedException("Feedback Review can only be inserted with an authenticated user.");
		}

		int userFeedbackCount = getCustomerFeedbackReviewDao().getCustomerFeedbackReviewCountForUser(currentUser);
		if (userFeedbackCount >= getMaxFeedbackPerCustomer()) {
			throw new MaximumFeedbackExceedException(
					"Maximum number of feedbacks per customer exceeded (" + getMaxFeedbackPerCustomer() + ")");
		}

		final CustomerFeedbackReviewModel customerFeedbackReviewModel = getModelService().create(CustomerFeedbackReviewModel.class);
		customerFeedbackReviewReversePopulator.populate(customerFeedbackReviewData, customerFeedbackReviewModel);
		getModelService().save(customerFeedbackReviewModel);

		return customerFeedbackReviewModel;
	}

	@Override
	public List<CustomerFeedbackReviewModel> getAllCustomerFeedbackReviewsForCurrentCustomer()
	{
		return getAllCustomerFeedbackReviewsForCustomer(getUserService().getCurrentUser());
	}

	@Override
	public List<CustomerFeedbackReviewModel> getAllCustomerFeedbackReviewsForCustomer(UserModel user)
	{
		validateParameterNotNull(user, "User cannot be null");

		return getCustomerFeedbackReviewDao().getAllCustomerFeedbackReviewsForUser(user);
	}

	private int getMaxFeedbackPerCustomer()
	{
		return getConfigurationService().getConfiguration().getInt(MAX_FEEDBACK_PER_CUSTOMER_CONFIG_KEY,
				MAX_FEEDBACK_PER_CUSTOMER);
	}

	public ConfigurationService getConfigurationService()
	{
		return configurationService;
	}

	@Required
	public void setConfigurationService(ConfigurationService configurationService)
	{
		this.configurationService = configurationService;
	}

	public CustomerFeedbackReviewDao getCustomerFeedbackReviewDao()
	{
		return customerFeedbackReviewDao;
	}

	@Required
	public void setCustomerFeedbackReviewDao(CustomerFeedbackReviewDao customerFeedbackReviewDao)
	{
		this.customerFeedbackReviewDao = customerFeedbackReviewDao;
	}

	public ModelService getModelService()
	{
		return modelService;
	}

	@Required
	public void setModelService(ModelService modelService)
	{
		this.modelService = modelService;
	}

	public UserService getUserService()
	{
		return userService;
	}

	@Required
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	public Populator<CustomerFeedbackReviewData, CustomerFeedbackReviewModel> getCustomerFeedbackReviewReversePopulator()
	{
		return customerFeedbackReviewReversePopulator;
	}

	@Required
	public void setCustomerFeedbackReviewReversePopulator(
			Populator<CustomerFeedbackReviewData, CustomerFeedbackReviewModel> customerFeedbackReviewReversePopulator)
	{
		this.customerFeedbackReviewReversePopulator = customerFeedbackReviewReversePopulator;
	}
}
