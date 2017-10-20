package com.nanosl.n.module.team;

import com.fasterxml.jackson.annotation.JsonView;
import com.nanosl.n.dao.Combo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nanosl.n.module.appsession.AppSessionService;
import com.nanosl.n.utility.Page;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private TeamService service;

    @JsonView(TeamView.AllAndMenuAll.class)
    @GetMapping
    public Iterable<Team> findAll() {
        return service.findAll();
    }

    @JsonView(TeamView.All.class)
    @GetMapping("/page")
    Page<Team> page(Pageable pageable) {
        return new Page<Team>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(TeamView.All.class)
    @PostMapping
    public Team save(@RequestBody Team team, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            team = service.save(team);
            return team;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Team> teams, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            for (Team team : teams) {
                team.setName(team.getName().trim());
                Team existingTeam = service.findByName(team.getName());
                if (existingTeam != null) {
                    team.setId(existingTeam.getId());
                }
            }
            service.save(teams);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(TeamView.All.class)
    @GetMapping("/{id}")
    public Team findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @JsonView(TeamView.All.class)
    @PutMapping("/{id}")
    public Team updateCustomer(@PathVariable int id, @RequestBody Team team, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        team.setId(id);
        team = service.save(team);
        return team;
    }

}
