package org.customer.feedback.converter.populator;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.user.UserService;

import org.customer.feedback.data.CustomerFeedbackReviewData;
import org.customer.feedback.model.CustomerFeedbackReviewModel;
import org.springframework.beans.factory.annotation.Required;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNull;


public class CustomerFeedbackReviewReversePopulator implements Populator<CustomerFeedbackReviewData, CustomerFeedbackReviewModel>
{
	private CommonI18NService commonI18NService;

	private UserService userService;

	@Override
	public void populate(CustomerFeedbackReviewData customerFeedbackReviewData,
			CustomerFeedbackReviewModel customerFeedbackReviewModel) throws ConversionException
	{
		validateParameterNotNull(customerFeedbackReviewData, "customerFeedbackReviewData cannot be null");
		validateParameterNotNull(customerFeedbackReviewModel, "customerFeedbackReviewModel cannot be null");

		customerFeedbackReviewModel.setLanguage(getCommonI18NService().getLanguage(customerFeedbackReviewData.getLang()));
		customerFeedbackReviewModel.setUser(getUserService().getCurrentUser());
		customerFeedbackReviewModel.setTitle(customerFeedbackReviewData.getTitle());
		customerFeedbackReviewModel.setContent(customerFeedbackReviewData.getContent());
	}

	public CommonI18NService getCommonI18NService()
	{
		return commonI18NService;
	}

	@Required
	public void setCommonI18NService(CommonI18NService commonI18NService)
	{
		this.commonI18NService = commonI18NService;
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
}
