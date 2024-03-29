package se.citerus.model;

import java.util.List;
import java.util.Map;

record WorkflowRun(
        Map<String, ?> actor,
        String artifacts_url,
        String cancel_url,
        Integer check_suite_id,
        String check_suite_node_id,
        String check_suite_url,
        String conclusion,
        String created_at,
        String display_title,
        String event,
        String head_branch,
        String head_commit,
        Map<String, ?> head_repository,
        String head_sha,
        String html_url,
        Integer id,
        String jobs_url,
        String logs_url,
        String name,
        String node_id,
        String path,
        String previous_attempt_url,
        List<String> pull_requests,
        List<String> referenced_workflows,
        Map<String, ?> repository,
        String rerun_url,
        Integer run_attempt,
        Integer run_number,
        String run_started_at,
        String status,
        Map<String, ?> triggering_actor,
        String updated_at,
        String url,
        Integer workflow_id,
        String workflow_url
) {
}
