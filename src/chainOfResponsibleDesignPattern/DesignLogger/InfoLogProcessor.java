package chainOfResponsibleDesignPattern.DesignLogger;

import java.util.Objects;

public class InfoLogProcessor extends LogProcessor {

    public InfoLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int level, String msg) {
        if (level == LogProcessor.info) {
            System.out.println("INFO " + msg);
        } else if (Objects.isNull(nextLogProcessor)) {
            System.out.println("Unknown log level given by user");
        } else {
            nextLogProcessor.log(level, msg);
        }
    }
}