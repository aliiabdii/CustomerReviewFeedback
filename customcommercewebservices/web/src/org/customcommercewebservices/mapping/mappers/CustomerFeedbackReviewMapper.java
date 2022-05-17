package org.customcommercewebservices.mapping.mappers;

import de.hybris.platform.webservicescommons.mapping.mappers.AbstractCustomMapper;

import org.customcommercewebservices.dto.CustomerFeedbackReviewWsDTO;
import org.customer.feedback.model.CustomerFeedbackReviewModel;

import ma.glasnost.orika.MappingContext;


public class CustomerFeedbackReviewMapper extends AbstractCustomMapper<CustomerFeedbackReviewModel, CustomerFeedbackReviewWsDTO>
{
	@Override
	public void mapAtoB(final CustomerFeedbackReviewModel a, final CustomerFeedbackReviewWsDTO b, final MappingContext context)
	{
		mapLanguage(a, b, context);
		mapDate(a, b, context);
		mapUserId(a, b, context);
	}

	protected void mapLanguage(CustomerFeedbackReviewModel a, CustomerFeedbackReviewWsDTO b, MappingContext context)
	{
		context.beginMappingField("language", getAType(), a, "lang", getBType(), b);

		try
		{
			if(shouldMap(a, b, context))
			{
				b.setLang(a.getLanguage().getIsocode());
			}
		}
		finally
		{
			context.endMappingField();
		}
	}

	protected void mapDate(CustomerFeedbackReviewModel a, CustomerFeedbackReviewWsDTO b, MappingContext context)
	{
		context.beginMappingField("creationTime", getAType(), a, "date", getBType(), b);

		try
		{
			if(shouldMap(a, b, context))
			{
				b.setDate(a.getCreationtime());
			}
		}
		finally
		{
			context.endMappingField();
		}
	}

	protected void mapUserId(CustomerFeedbackReviewModel a, CustomerFeedbackReviewWsDTO b, MappingContext context)
	{
		context.beginMappingField("user", getAType(), a, "userId", getBType(), b);

		try
		{
			if(shouldMap(a, b, context))
			{
				b.setUserId(a.getUser().getUid());
			}
		}
		finally
		{
			context.endMappingField();
		}
	}
}
