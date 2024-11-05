package chainOfResponsibleDesignPattern.DesignLogger;

import java.util.Objects;

public class DebugLogProcessor extends LogProcessor {


    public DebugLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int level, String msg) {
        if (level == LogProcessor.debug) {
            System.out.println("DEBUG " + msg);
        } else if (Objects.isNull(nextLogProcessor)) {
            System.out.println("Unknown log level given by user");
        } else {
            nextLogProcessor.log(level, msg);
        }
    }
}
