package org.greedy.gateway.interfaces.api.controller.external;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.greedy.gateway.application.dto.ProjectDTO;
import org.greedy.gateway.application.service.ProjectAppService;
import org.greedy.gateway.interfaces.api.common.Result;
import org.greedy.gateway.interfaces.api.request.ProjectCreateRequest;

/**
 * 项目控制器
 * 提供项目相关的REST API接口
 * 
 * @author greedy
 * @since 1.0.0
 */
@RestController
@RequestMapping("/projects")
public class ProjectController {

    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

    private final ProjectAppService projectAppService;

    public ProjectController(ProjectAppService projectAppService) {
        this.projectAppService = projectAppService;
    }

    /**
     * 创建项目
     */
    @PostMapping
    public Result<ProjectDTO> createProject(@Valid @RequestBody ProjectCreateRequest request) {
        logger.info("接收创建项目请求: {}", request);

        ProjectDTO result = projectAppService.createProject(request);
        
        logger.info("创建项目成功，项目ID: {}", result.getId());
        return Result.success("项目创建成功", result);
    }

} 