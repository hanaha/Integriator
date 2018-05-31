package net.integriator.data.mapper;

import net.integriator.data.Node;
import net.integriator.data.entity.NodeEntity;

import java.util.function.Function;

public class NodeMapper implements Function<NodeEntity, Node> {

    @Override
    public Node apply(NodeEntity nodeEntity) {
        return new Node(new WorldMapper().apply(nodeEntity.getWorldEntity()), nodeEntity.getParentNodeId(), nodeEntity.getTitle(), nodeEntity.getDescription());
    }
}
