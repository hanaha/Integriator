package net.integriator.data.mapper;

import net.integriator.data.World;
import net.integriator.data.entity.WorldEntity;

import java.util.function.Function;

public class WorldMapper implements Function<WorldEntity, World> {

    @Override
    public World apply(WorldEntity worldEntity) {
        return new World(worldEntity.getName(), worldEntity.getDescription());
    }
}
