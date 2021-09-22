package flow3.entity;

import java.util.LinkedList;
import java.util.Queue;

public class Task {
    Integer taskId;
    Integer version;
    String alias;
    String note;
    Queue<Node> nodes; // ordered

    public Task(){
        this.nodes = new LinkedList<Node>();
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Queue<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Queue<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNodes(Node node) { this.nodes.add(node); }

}
