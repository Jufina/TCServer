package com.complete.jsonview;

import org.aspectj.apache.bcel.classfile.Code;

/**
 * Created by Rina on 26.05.2016.
 */
public interface SolutionView {

    interface  SolView extends  IdView,CodeView,ScoreView,timeSendView,languageView, com.complete.jsonview.TaskView.TaskForContestView {}

    interface IdView { }
    interface TaskView extends com.complete.jsonview.TaskView.IdView{}
    public interface CodeView {
    }

    public interface ScoreView {
    }

    public interface timeSendView {

    }
    public interface languageView {

    }
}
