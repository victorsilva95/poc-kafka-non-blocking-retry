package com.github.victorsilva95.pockafkanonblockingretry.exception;

public class IncompleteAnimeException extends RuntimeException{
    public IncompleteAnimeException() {
        super("All the anime fields were not filled");
    }
}
