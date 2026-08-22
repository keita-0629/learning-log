package com.example.its.web.issue;

import com.example.its.domain.issue.IssueService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/issues")
@RequiredArgsConstructor
public class IssueController {

    private final IssueService issueService;

    @GetMapping
    public String showList(Model model) {

        model.addAttribute("issueList", issueService.findAll());

        return "issues/List";

    }

    // GET /issues/creationForm
    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute IssueForm form) {

        return "issues/creationForm";
    }

    // POST /issues
    @PostMapping
    public String creat(@Validated IssueForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return showCreationForm(form);
        }
        issueService.create(form.getSummary(), form.getDescription());

        return "redirect:/issues";

    }

    @GetMapping("/{issueId}")
    public String showDetail(@PathVariable("issueId") long issueId, Model model) {

        model.addAttribute("issue", issueService.findById(issueId));
        return "issues/detail";
    }

    @PostMapping("/{issueId}/delete")
    public String delete(@PathVariable("issueId") long issueId) {
        issueService.deleteById(issueId);
        return "redirect:/issues";
    }

    @GetMapping("/{issueId}/edit")
    public String edit(@PathVariable("issueId") long issueId, Model model) {
        model.addAttribute("issue", issueService.findById(issueId));
        return "issues/editissue";
    }

    @PostMapping("/{issueId}/edit")
    public String postEdit(@PathVariable("issueId") long issueId, @Validated IssueForm form,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "issues/editissue";
        }
        issueService.editById(issueId, form.getSummary(), form.getDescription());

        return "redirect:/issues/" + issueId;
    }

}