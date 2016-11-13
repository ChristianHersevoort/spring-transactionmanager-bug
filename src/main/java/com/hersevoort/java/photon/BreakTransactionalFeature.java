package com.hersevoort.java.photon;

import org.apache.cxf.feature.LoggingFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * This class breaks the @Transactional on ShouldHaveTransactional
 *
 * @author Christian Hersevoort
 */
public class BreakTransactionalFeature extends LoggingFeature {

    private final static Logger LOG = LoggerFactory.getLogger(BreakTransactionalFeature.class);

    // FIXME: switching to field-injection fixes the issue..
    // @Inject
    private ShouldHaveTransactional shouldHaveTransactional;

    @Inject
    public BreakTransactionalFeature(final ShouldHaveTransactional shouldHaveTransactional)
    {
        LOG.error("I am called BEFORE the ProxyTransactionManagementConfiguration.transactionAdvisor() causing the ShouldHaveTransactional class to be initialized to early");
        this.shouldHaveTransactional = shouldHaveTransactional;
    }
}
