package chainOfResponsibleDesignPattern.DesignLogger;

import java.util.Objects;

public abstract class LogProcessor {

    public static int info = 1;
    public static int debug = 2;
    public static int error = 3;

    public LogProcessor nextLogProcessor;

    public LogProcessor(LogProcessor nextLogProcessor){
        this.nextLogProcessor = nextLogProcessor;
    }

    public void log(int level, String msg){
        if(Objects.nonNull(nextLogProcessor)){
            nextLogProcessor.log(level,msg);
        }
    }



}
