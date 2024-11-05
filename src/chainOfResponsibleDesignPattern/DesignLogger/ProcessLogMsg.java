package chainOfResponsibleDesignPattern.DesignLogger;

public class ProcessLogMsg {

    public static void main(String[] args) {
        InfoLogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logProcessor.log(LogProcessor.debug,"You have debug message");
        logProcessor.log(LogProcessor.info,"You have info message");
        logProcessor.log(LogProcessor.error,"You have error message");
        logProcessor.log(5,"You have unknown message");
    }
}
