package flow3.runtime;


import java.util.Map;

public interface FlowInst {

    public Integer run();

    public Map<String, Object> getFacts();

}
