package org.customer.feedback.dao;

import de.hybris.platform.core.model.user.UserModel;

import java.util.List;

import org.customer.feedback.model.CustomerFeedbackReviewModel;

/**
 * DAO for {@link CustomerFeedbackReviewModel} access.
 */
public interface CustomerFeedbackReviewDao
{
	/**
	 * Find the total number of feedbacks for a given user
	 * @param user requested user
	 * @return Integer which is the number of feedbacks
	 */
	int getCustomerFeedbackReviewCountForUser(UserModel user);

	/**
	 * Get all the feedbacks for a given user
	 * @param user requested user
	 * @return List of {@link CustomerFeedbackReviewModel}
	 */
	List<CustomerFeedbackReviewModel> getAllCustomerFeedbackReviewsForUser(UserModel user);
}
