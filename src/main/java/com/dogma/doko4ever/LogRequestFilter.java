package com.dogma.doko4ever;

import org.springframework.web.filter.CommonsRequestLoggingFilter;

//@Component
//@Order(1)
public class LogRequestFilter extends CommonsRequestLoggingFilter {

	//	private final Logger logger = LoggerFactory.getLogger(LogRequestFilter.class);
	//
	//	@Override
	//	protected void beforeRequest(HttpServletRequest request, String message) {
	//		// init logging with transaction id
	//		String transactionid = request.getHeader("transactionID");
	//		if (logger == null) {
	//			logger.warn("transaction id was not set");
	//		} else {
	//			ThreadContext.put("transactionID", transactionid);
	//		}
	//
	//		logger.info("Received Request {} : {} for transaction id {}", request.getMethod(), request.getRequestURI(),
	//				transactionid);
	//		if (logger.isDebugEnabled()) {
	//			logger.debug("Payload: " + getMessagePayload(request));
	//		}
	//	}
	//
	//	@Override
	//	protected void afterRequest(HttpServletRequest request, String message) {
	//		logger.info("Sent Response");
	//	}

	public LogRequestFilter() {
		super.setMaxPayloadLength(2000);
		super.setIncludePayload(true);
		super.setIncludeQueryString(true);
		super.setIncludeHeaders(true);
	}
}
