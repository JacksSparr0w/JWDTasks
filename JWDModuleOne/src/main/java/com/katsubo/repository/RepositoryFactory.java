package com.katsubo.repository;

public abstract class RepositoryFactory {
    public static Repository getRepository(RepositoryType type){
        Repository repository = null;
        switch (type){
            case TOY_ROOM:
                repository = ToyRoomRepository.getInstance();
                break;
            default:
                break;
        }
        return repository;
    }
}
