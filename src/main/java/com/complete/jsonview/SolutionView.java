package com.complete.jsonview;

/**
 * Created by Rina on 26.05.2016.
 */
public interface SolutionView {

    interface  MyView extends  IdView, TaskView {}

    interface IdView { }
    interface TaskView extends com.complete.jsonview.TaskView.IdView{}
}
