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
package org.customer.feedback.service;

import de.hybris.platform.core.model.user.UserModel;

import java.util.List;

import org.customer.feedback.data.CustomerFeedbackReviewData;
import org.customer.feedback.model.CustomerFeedbackReviewModel;


/**
 * Core provider service for {@link CustomerFeedbackReviewModel}
 */
public interface CustomerFeedbackService
{
	/**
	 * Creates a new customer feedback review for the current logged-in user
	 * @param customerFeedbackReviewData Data containing the new feedback review
	 * @param langIsoCode language iso code of the review (de, es, ...)
	 * @return the inserted feedback review model
	 */
	CustomerFeedbackReviewModel addCustomerFeedbackReview(CustomerFeedbackReviewData customerFeedbackReviewData);

	List<CustomerFeedbackReviewModel> getAllCustomerFeedbackReviewsForCurrentCustomer();
	List<CustomerFeedbackReviewModel> getAllCustomerFeedbackReviewsForCustomer(UserModel user);
}
