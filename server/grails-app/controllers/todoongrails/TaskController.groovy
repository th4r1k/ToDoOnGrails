package todoongrails


import grails.converters.*
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses

import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path('/task')
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "task")
class TaskController {

    def taskService

    @GET
    @ApiOperation(value = "Get all tasks", response = Task.class, responseContainer = "List")
    @ApiResponses(value = [
            @ApiResponse( code = 200, message = "Successfully get"),
            @ApiResponse( code = 404, message = "Resource you were trying to reach is not found")
    ])
    def index() {
        render taskService.listTask() as JSON
    }

    @POST
    @ApiOperation(value = "Create new task")
    @ApiResponses(value = [
            @ApiResponse( code = 201, message = "Task created"),
            @ApiResponse( code = 400, message = "Fail to create task")
    ])
    def save(Task task) {
        if (task.hasErrors()) {
            render status: 400, text: "Fail to create task"
            return
        }

        taskService.saveTask(task)
        render status: 201, text: "Task created"
    }

    @PUT
    @Path('/id')
    @ApiOperation(value = "Update task")
    @ApiResponses(value = [
            @ApiResponse( code = 200, message = "Task updated"),
            @ApiResponse( code = 400, message = "Fail to update task")
    ])
    def update(Task task) {
        if (task.hasErrors()) {
            render status: 400, text: "Fail to update task"
            return
        }

        taskService.updateTask(task)
        render status: 200, text: "Task updated"
    }

    @DELETE
    @Path('/id')
    @ApiOperation(value = "Delete task")
    @ApiResponses(value = [
            @ApiResponse( code = 200, message = "Task deleted"),
            @ApiResponse( code = 400, message = "Fail to delete task")
    ])
    def delete(Task task) {
        taskService.deleteTask(task)
        render status: 200, text: "Task deleted"
    }
}
