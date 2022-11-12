import java.util.HashSet;
import java.util.Set;

public enum TrainedCommand{;
    private Set<TrainedCommand> trainedCommands = new HashSet<>();

    public String[] getTrainedCommands() {
        String[] commands = new String[trainedCommands.size()];
        int i = 0;
        for (TrainedCommand trainedCommand:trainedCommands) {
            commands [i]= String.valueOf(trainedCommands);
            i++;
        }
        return commands;
    }

    public void train(String command) {
        TrainedCommand trainedCommand = TrainedCommand.valueOf(command);
        trainedCommands.add(trainedCommand);
    }
}



