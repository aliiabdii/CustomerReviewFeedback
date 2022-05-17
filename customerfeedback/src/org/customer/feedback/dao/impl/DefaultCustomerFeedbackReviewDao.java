package org.customer.feedback.dao.impl;

import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.Collections;
import java.util.List;

import org.customer.feedback.dao.CustomerFeedbackReviewDao;
import org.customer.feedback.model.CustomerFeedbackReviewModel;


public class DefaultCustomerFeedbackReviewDao extends DefaultGenericDao<CustomerFeedbackReviewModel>
		implements CustomerFeedbackReviewDao
{
	public DefaultCustomerFeedbackReviewDao()
	{
		super(CustomerFeedbackReviewModel._TYPECODE);
	}

	@Override
	public int getCustomerFeedbackReviewCountForUser(UserModel user)
	{
		String queryString = " SELECT COUNT({" + CustomerFeedbackReviewModel.PK + "}) "
				+ " FROM {" + CustomerFeedbackReviewModel._TYPECODE + "} "
				+ " WHERE {" + CustomerFeedbackReviewModel.USER + "} = ?user ";

		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString, Collections.singletonMap("user", user));
		query.setResultClassList(Collections.singletonList(Integer.class));

		final SearchResult<Integer> result = getFlexibleSearchService().search(query);
		return result.getResult().get(0);
	}

	@Override
	public List<CustomerFeedbackReviewModel> getAllCustomerFeedbackReviewsForUser(UserModel user) {
		return this.find(Collections.singletonMap(CustomerFeedbackReviewModel.USER, user));
	}
}
