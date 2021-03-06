package io.onedev.server.web.util.ajaxlistener;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.attributes.IAjaxCallListener;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.handler.resource.ResourceReferenceRequestHandler;

import io.onedev.server.web.behavior.AbstractPostAjaxBehavior;

public class AppendLoadingIndicatorListener implements IAjaxCallListener {

	private final boolean indicateSuccessful;
	
	public AppendLoadingIndicatorListener(boolean indicateSuccessful) {
		this.indicateSuccessful = indicateSuccessful;
	}
	
	@Override
	public CharSequence getBeforeHandler(Component component) {
		return null;
	}

	@Override
	public CharSequence getPrecondition(Component component) {
		return null;
	}

	@Override
	public CharSequence getBeforeSendHandler(Component component) {
		IRequestHandler handler = new ResourceReferenceRequestHandler(
				AbstractPostAjaxBehavior.INDICATOR);
		CharSequence url = RequestCycle.get().urlFor(handler);
		return String.format(""
				+ "$('#%s-working-indicator').remove(); "
				+ "$('#%s').after('<img id=\"%s-working-indicator\" src=\"%s\" class=\"working-indicator\"></img>');", 
				component.getMarkupId(), component.getMarkupId(), component.getMarkupId(), url);
	}

	@Override
	public CharSequence getAfterHandler(Component component) {
		return null;
	}

	@Override
	public CharSequence getSuccessHandler(Component component) {
		if (indicateSuccessful) {
			return String.format(""
					+ "$('#%s-working-indicator').remove();"
					+ "$('#%s').after('<span id=\"%s-working-indicator\" class=\"fa fa-check working-indicator\"></span>');", 
					component.getMarkupId(), component.getMarkupId(), component.getMarkupId());
		} else {
			return String.format("$('#%s-working-indicator').remove();", component.getMarkupId());
		}
	}

	@Override
	public CharSequence getFailureHandler(Component component) {
		return null;
	}

	@Override
	public CharSequence getCompleteHandler(Component component) {
		return null;
	}

	@Override
	public CharSequence getInitHandler(Component component) {
		return null;
	}

	@Override
	public CharSequence getDoneHandler(Component component) {
		return null;
	}

}
