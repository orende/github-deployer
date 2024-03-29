package se.citerus;

import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.citerus.clients.GithubRestClient;
import se.citerus.config.AppConfig;
import se.citerus.config.ConfigHandler;

import java.util.Optional;

public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Optional<String> configFilePath = args.length > 0 && args[0] != null ? Optional.of(args[0]) : Optional.empty();
        AppConfig config = configFilePath.map(ConfigHandler::parseConfigFile)
                .orElseGet(ConfigHandler::parseConfigFile);

        // TODO create deployment pipeline with manual trigger and test it
        var ghClient = new GithubRestClient(config);
        var app = Javalin.create(/*config*/)
                .post("/webhook", new WebhookHandler(ghClient, config))
                .get("/logs/{deploymentId}", new LogsHandler())
                .start(config.port);
    }
}