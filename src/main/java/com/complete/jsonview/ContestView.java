package com.complete.jsonview;

/**
 * Created by Rina on 27.05.2016.
 */
public interface ContestView {
    interface IdView { }
    interface NameView { }
    interface IdAndNameView extends IdView, NameView {}
}
