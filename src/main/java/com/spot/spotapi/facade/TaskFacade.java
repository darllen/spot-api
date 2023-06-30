package com.spot.spotapi.facade;

import com.spot.spotapi.dto.TaskDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskFacade {
    private static final Map<Long, TaskDTO> tasks = new HashMap<>();

    public TaskDTO create(TaskDTO tarefa){
        Long id = tasks.keySet().size() + 1L;
        tarefa.setId(id);

        tasks.put(id, tarefa);
        return tarefa;
    }

    public TaskDTO update(TaskDTO tarefa, Long id){
        tasks.put(id, tarefa);
        return tarefa;
    }

    public TaskDTO getById(Long id){
        return tasks.get(id);
    }

    public List<TaskDTO> getAll(){
        return new ArrayList<>(tasks.values());
    }

    public String delete(Long id){
        tasks.remove(id);
        return "deleted!";
    }
}
