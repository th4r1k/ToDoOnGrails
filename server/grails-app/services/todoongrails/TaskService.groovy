package todoongrails

import grails.gorm.transactions.Transactional

@Transactional
class TaskService {

    def listTask() {
        Task.list()
    }

    def saveTask(Task task) {
        task.save()
    }

    def updateTask(Task task) {
        task.merge()
    }

    def deleteTask(Task task) {
        task.delete()
    }
}
