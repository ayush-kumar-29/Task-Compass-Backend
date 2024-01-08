package workcompass.backend.sprint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SprintController {
    @Autowired
    private SprintDaoService sprintDaoService;
    @Autowired
    private SprintStateManagerService sprintStateManagerService;

    @GetMapping(value = "/sprints")
    public List<Sprint> getSprintList(@RequestParam boolean upcomingFilter, @RequestParam boolean ongoingFilter,
                                      @RequestParam boolean closedFilter){
        return sprintDaoService.getSprintListForFilter(upcomingFilter, ongoingFilter, closedFilter);
    }

    @GetMapping(value = "/sprints/{sprintId}")
    public Sprint getSprintForId(@PathVariable String sprintId){
        return sprintDaoService.getSprintForId(sprintId);
    }

    @GetMapping(value = "/listSprints")
    public List<String> getSprintNames(){
        return sprintDaoService.getSprintNames();
    }

    @GetMapping(value = "/sprints/exists")
    public boolean validateSprintName(@RequestParam String sprintName){
        return sprintDaoService.sprintNameExists(sprintName);
    }

    @PostMapping(value = "/sprints/createSprint")
    public void addSprint(@RequestBody Sprint newSprint){
        sprintDaoService.addSprint(newSprint, true);
    }

    @DeleteMapping(value = "/sprints/deleteSprint/{sprintId}")
    public void deleteSprint(@PathVariable String sprintId){
        sprintStateManagerService.deleteSprint(sprintId, true);
    }

    @PatchMapping(value = "/sprints/updateSprint/{sprintId}")
    public void updateSprintStatus(@PathVariable String sprintId, @RequestParam String updateType,
                                   @RequestParam String newStatus, @RequestBody Sprint sprintPatch){
        if(updateType.equalsIgnoreCase("status"))
            sprintStateManagerService.updateSprint(sprintId, newStatus);
        else if(updateType.equalsIgnoreCase("content"))
            sprintStateManagerService.updateSprint(sprintId, sprintPatch);
    }
}
