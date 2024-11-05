package chainOfResponsibleDesignPattern.DesignLogger;

import java.util.Objects;

public class ErrorLogProcessor extends LogProcessor {


    public ErrorLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }


    public void log(int level, String msg) {
        if (level == LogProcessor.error) {
            System.out.println("ERROR " + msg);
        } else if (Objects.isNull(nextLogProcessor)) {
            System.out.println("Unknown log level given by user");
        } else {
            nextLogProcessor.log(level, msg);
        }
    }
}
