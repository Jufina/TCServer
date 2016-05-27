package com.complete.jsonview;

/**
 * Created by Rina on 26.05.2016.
 */
public interface TaskView {

    interface TaskGeneralView extends IdView, NameView,DecriptionView, NoteView, ContestIdView, ContestNameView { }
    interface TaskForContestView extends IdView, NameView,DecriptionView,NoteView { }
    interface TaskTestView extends IdView, NameView { }
    interface IdView { }
    interface NameView { }
    interface DecriptionView { }
    interface NoteView { }
    interface ContestIdView extends com.complete.jsonview.ContestView.IdView{}
    interface ContestNameView extends com.complete.jsonview.ContestView.NameView{}
}
