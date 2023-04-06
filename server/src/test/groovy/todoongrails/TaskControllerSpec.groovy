package todoongrails

import grails.testing.web.controllers.ControllerUnitTest
import groovy.json.JsonSlurper
import spock.lang.Specification

class TaskControllerSpec extends Specification implements ControllerUnitTest<TaskController> {

    def setup() {
    }

    def cleanup() {
    }

    void "test index method (/GET)"() {
        given:
        controller.taskService = Mock(TaskService) {
            listTask() >> new JsonSlurper().parseText('{"name": "teste", "description": "teste"}')
        }
        when:
        controller.index()

        then:
        response.status == 200
        response.contentType == "application/json;charset=UTF-8"
        response.json == ["name":"teste", "description":"teste"]
    }

    void "test save method (/POST) with valid Task"() {
        given:
        Task validUser = new Task(name: "teste", description: "teste", endDate: "11/11/1111", endTime: "11:11 ", status: "done", priority: "3", category: "teste" )
        controller.taskService = Mock(TaskService)

        when:
        controller.save(validUser)

        then:
        response.status == 201
        response.contentType == "text/html;charset=utf-8"
        response.text == "Task created"
    }

    void "test save method (/POST) with invalid Task"() {
        given:
        Task invalidUser = new Task()
        controller.taskService = Mock(TaskService)
        when:
        def result = controller.save(invalidUser)

        then:
        response.status == 400
        response.text == "Fail to create task"
    }

    void "test update method (/PUT) with valid Task"() {
        given:
        Task testeTask = new Task(name: "teste", description: "teste", endDate: "11/11/1111", endTime: "11:11 ", status: "done", priority: "3", category: "teste" )
        controller.taskService = Mock(TaskService) {
            updateTask(Task as Task) >> "status: 300, text: \"Task updated\""
        }
        when:
        controller.update(testeTask)

        then:
        response.status == 200
        response.contentType == "text/html;charset=utf-8"
        response.text == "Task updated"
    }

    void "test update method (/PUT) with invalid Task"() {
        given:
        Task invalidTask = new Task()
        controller.taskService = Mock(TaskService)

        when:
        controller.update(invalidTask)

        then:
        response.status == 400
        response.contentType == "text/html;charset=utf-8"
        response.text == "Fail to update task"
    }

    void "test delete method (/Delete) with valid Task"() {
        given:
        Task testeTask = new Task(name: "teste", description: "teste", endDate: "11/11/1111", endTime: "11:11 ", status: "done", priority: "3", category: "teste" )
        controller.taskService = Mock(TaskService)

        when:
        controller.delete(testeTask)

        then:
        response.status == 200
        response.contentType == "text/html;charset=utf-8"
        response.text == "Task deleted"
    }

    void "test delete method (/Delete) with invalid Task"() {
        given:
        Task testeTask = new Task()
        controller.taskService = Mock(TaskService)

        when:
        controller.delete(testeTask)

        then:
        response.status == 400
        response.contentType == "text/html;charset=utf-8"
        response.text == "Fail to delete task"
    }


}