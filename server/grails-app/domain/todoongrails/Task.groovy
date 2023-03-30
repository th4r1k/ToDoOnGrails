package todoongrails

class Task {

    String name
    String description
    String endDate
    String endTime
    String priority
    String category
    String status

    static constraints = {
        name unique:true, blank:false
        description blank:false
        endDate blank:false , matches:"(0[1-9]|1[0-9]|2[0-9]|3[0-1]|[1-9])/((0[1-9]|1[0-2]|[1-9])/([0-9]{4}))"
        endTime blank:false , matches:"(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]"
        priority blank:false , matches:"[1-5]"
        category blank:false
        status blank:false , matches:"todo|doing|done"
    }
}
