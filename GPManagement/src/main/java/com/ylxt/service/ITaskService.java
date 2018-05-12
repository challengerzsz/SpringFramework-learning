package com.ylxt.service;

import com.ylxt.common.ServerResponse;
import com.ylxt.pojo.Task;

public interface ITaskService {
    ServerResponse<Task> getSelectedTask();


}
