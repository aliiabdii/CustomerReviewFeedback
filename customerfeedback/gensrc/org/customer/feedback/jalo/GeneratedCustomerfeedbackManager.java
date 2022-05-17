/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 15, 2022 11:00:27 PM                    ---
 * ----------------------------------------------------------------
 */
package org.customer.feedback.jalo;

import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.security.Principal;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.util.OneToManyHandler;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.customer.feedback.constants.CustomerfeedbackConstants;
import org.customer.feedback.jalo.CustomerFeedbackReview;

/**
 * Generated class for type <code>CustomerfeedbackManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedCustomerfeedbackManager extends Extension
{
	/**
	* {@link OneToManyHandler} for handling 1:n CUSTOMERFEEDBACKREVIEWS's relation attributes from 'many' side.
	**/
	protected static final OneToManyHandler<CustomerFeedbackReview> CUSTOMERFEEDBACKREVIEWTOUSERRELCUSTOMERFEEDBACKREVIEWSHANDLER = new OneToManyHandler<CustomerFeedbackReview>(
	CustomerfeedbackConstants.TC.CUSTOMERFEEDBACKREVIEW,
	false,
	"user",
	null,
	false,
	true,
	CollectionType.COLLECTION
	);
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	public CustomerFeedbackReview createCustomerFeedbackReview(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( CustomerfeedbackConstants.TC.CUSTOMERFEEDBACKREVIEW );
			return (CustomerFeedbackReview)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating CustomerFeedbackReview : "+e.getMessage(), 0 );
		}
	}
	
	public CustomerFeedbackReview createCustomerFeedbackReview(final Map attributeValues)
	{
		return createCustomerFeedbackReview( getSession().getSessionContext(), attributeValues );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>User.customerFeedbackReviews</code> attribute.
	 * @return the customerFeedbackReviews
	 */
	public Collection<CustomerFeedbackReview> getCustomerFeedbackReviews(final SessionContext ctx, final User item)
	{
		return CUSTOMERFEEDBACKREVIEWTOUSERRELCUSTOMERFEEDBACKREVIEWSHANDLER.getValues( ctx, item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>User.customerFeedbackReviews</code> attribute.
	 * @return the customerFeedbackReviews
	 */
	public Collection<CustomerFeedbackReview> getCustomerFeedbackReviews(final User item)
	{
		return getCustomerFeedbackReviews( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>User.customerFeedbackReviews</code> attribute. 
	 * @param value the customerFeedbackReviews
	 */
	protected void setCustomerFeedbackReviews(final SessionContext ctx, final User item, final Collection<CustomerFeedbackReview> value)
	{
		if ( ctx == null) 
		{
			throw new JaloInvalidParameterException( "ctx is null", 0 );
		}
		// initial-only attribute: make sure this attribute can be set during item creation only
		if ( ctx.getAttribute( "core.types.creation.initial") != Boolean.TRUE )
		{
			throw new JaloInvalidParameterException( "attribute '"+CustomerfeedbackConstants.Attributes.User.CUSTOMERFEEDBACKREVIEWS+"' is not changeable", 0 );
		}
		CUSTOMERFEEDBACKREVIEWTOUSERRELCUSTOMERFEEDBACKREVIEWSHANDLER.setValues( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>User.customerFeedbackReviews</code> attribute. 
	 * @param value the customerFeedbackReviews
	 */
	protected void setCustomerFeedbackReviews(final User item, final Collection<CustomerFeedbackReview> value)
	{
		setCustomerFeedbackReviews( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to customerFeedbackReviews. 
	 * @param value the item to add to customerFeedbackReviews
	 */
	protected void addToCustomerFeedbackReviews(final SessionContext ctx, final User item, final CustomerFeedbackReview value)
	{
		// initial-only attribute: make sure this attribute can be set during item creation only
		if ( ctx.getAttribute( "core.types.creation.initial") != Boolean.TRUE )
		{
			throw new JaloInvalidParameterException( "attribute '"+CustomerfeedbackConstants.Attributes.User.CUSTOMERFEEDBACKREVIEWS+"' is not changeable", 0 );
		}
		CUSTOMERFEEDBACKREVIEWTOUSERRELCUSTOMERFEEDBACKREVIEWSHANDLER.addValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to customerFeedbackReviews. 
	 * @param value the item to add to customerFeedbackReviews
	 */
	protected void addToCustomerFeedbackReviews(final User item, final CustomerFeedbackReview value)
	{
		addToCustomerFeedbackReviews( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from customerFeedbackReviews. 
	 * @param value the item to remove from customerFeedbackReviews
	 */
	protected void removeFromCustomerFeedbackReviews(final SessionContext ctx, final User item, final CustomerFeedbackReview value)
	{
		// initial-only attribute: make sure this attribute can be set during item creation only
		if ( ctx.getAttribute( "core.types.creation.initial") != Boolean.TRUE )
		{
			throw new JaloInvalidParameterException( "attribute '"+CustomerfeedbackConstants.Attributes.User.CUSTOMERFEEDBACKREVIEWS+"' is not changeable", 0 );
		}
		CUSTOMERFEEDBACKREVIEWTOUSERRELCUSTOMERFEEDBACKREVIEWSHANDLER.removeValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from customerFeedbackReviews. 
	 * @param value the item to remove from customerFeedbackReviews
	 */
	protected void removeFromCustomerFeedbackReviews(final User item, final CustomerFeedbackReview value)
	{
		removeFromCustomerFeedbackReviews( getSession().getSessionContext(), item, value );
	}
	
	@Override
	public String getName()
	{
		return CustomerfeedbackConstants.EXTENSIONNAME;
	}
	
}
