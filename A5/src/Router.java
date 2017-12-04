import java.util.Map;
import java.util.*;

//is it possible to get from start to end
public class Router {

    public Map<String, City> database;
    ArrayList<String> listOfRoutes = new ArrayList<>();
    int numOfSteps = 0;

    public Router (Map<String, City> database) {
        this.database = database;
        //probably save that database off as a class member variable
    }

    //search to find a route from start to finish in maxSteps or less steps
    public Iterable <String> route(String start, String finish, int maxSteps) {
        DFS(start, finish, maxSteps, listOfRoutes);
        return listOfRoutes;
    }

    public void DFS(String start, String finish, int maxSteps, ArrayList<String> listOfRoutes) {
        numOfSteps++;
        listOfRoutes.add(start);

        if (listOfRoutes.size() > maxSteps) { return; }

        if (start.equals(finish)) { return; }

        for (City city : database.get(start).getNeighbours()) {
            if (!(listOfRoutes.contains(finish))) {
                DFS(city.getName(), finish, maxSteps, listOfRoutes);
            }
            listOfRoutes.remove(listOfRoutes.size() - 1);
            numOfSteps--;
            return;
        }
    }
}

