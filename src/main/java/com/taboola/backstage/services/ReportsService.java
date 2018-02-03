package com.taboola.backstage.services;

/**
 * Reports
 *
 * <p>
 *    It’s important to note that data in Taboola reports can (and will) change retroactively during the
 *    Taboola billing cycle. This can happen because of multiple reasons, including, but not limited to
 *    - billing rules that define guarantees as per average monthly RPMs, changes in billing rules
 *    during the billing cycle, click or impression fraud that is credited, conversions that arrive out of
 *    order.
 * </p>
 * <p>
 *    This means that when fetching reports data from Taboola for a data warehouse or BI solution,
 *    the data for the entire billing cycle (current calendar month + previous calendar month up to the
 *    5th in any given month) should be periodically refreshed.
 * </p>
 *
 * <p>
 *    Note: the dimensions are the equivalent of the different tabs of the relevant report in Backstage,
 *    Taboola’s management system for advertisers and publishers
 * </p>
 * @author vladi
 * @version 1.0
 */
public interface ReportsService extends AdvertiserReportsService, PublisherReportsService {

}
