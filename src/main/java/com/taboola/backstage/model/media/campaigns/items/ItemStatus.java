package com.taboola.backstage.model.media.campaigns.items;

/**
 * Items with status=RUNNING is the only item that is being served in Taboola Widgets.
 *
 * Created by vladi
 * Date: 12/23/2017
 * Time: 10:31 PM
 * By Taboola
 */
public enum ItemStatus {
    RUNNING,
    CRAWLING,
    CRAWLING_ERROR,
    NEED_TO_EDIT,
    PAUSED,
    STOPPED,
    PENDING_APPROVAL,
    REJECTED
}
