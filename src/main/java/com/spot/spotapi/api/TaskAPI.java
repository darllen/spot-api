package com.spot.spotapi.api;


import com.spot.spotapi.dto.TaskDTO;
import com.spot.spotapi.facade.TaskFacade;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskAPI {
    @Autowired
    private TaskFacade taskFacade;

    @PostMapping
    @ResponseBody
    private TaskDTO create(@RequestBody TaskDTO tarefa){
        return taskFacade.create(tarefa);
    }

    @PutMapping("/{id}")
    @ResponseBody
    private TaskDTO update(@PathVariable("id") Long id, @RequestBody TaskDTO tarefa){
        return taskFacade.update(tarefa, id);
    }

    @GetMapping
    @ResponseBody
    public List<TaskDTO> getAll(){
        return taskFacade.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") Long id){
        return taskFacade.delete(id);

    }



}
