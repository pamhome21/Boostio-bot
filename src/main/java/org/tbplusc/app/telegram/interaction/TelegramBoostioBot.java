package org.tbplusc.app.telegram.interaction;

import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.tbplusc.app.message.processing.MessageHandler;
import org.tbplusc.app.util.EnvWrapper;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramBoostioBot extends TelegramLongPollingBot {
    private final String token = EnvWrapper.getValue("TELEGRAM_TOKEN");
    private MessageHandler messageHandler;
    private Logger logger;

//    public TelegramBoostioBot(MessageHandler messageHandler, Logger logger) {
//        this.messageHandler = messageHandler;
//        this.logger = logger;
//    }

    public void setUp(MessageHandler messageHandler, Logger logger){
        this.logger = logger;
        this.messageHandler = messageHandler;
    }

    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public String getBotUsername() {
        return "boostio_bot";
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            messageHandler.handleMessage(new WrappedTelegramMessage(update.getMessage(), this));
        }
    }
}