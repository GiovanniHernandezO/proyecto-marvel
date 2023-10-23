package com.test.api.marvelchallenge.persistence.integration.marvel.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.test.api.marvelchallenge.persistence.integration.marvel.dto.CharacterDto;
import com.test.api.marvelchallenge.persistence.integration.marvel.dto.ComicDto;
import com.test.api.marvelchallenge.persistence.integration.marvel.dto.ThumbnailDto;

import java.util.ArrayList;
import java.util.List;

public class ComicMapper {

    public static List<ComicDto> toDtoList(JsonNode rootNode) {
        ArrayNode resultsNode = getResultsNode(rootNode);
        List<ComicDto> comicc = new ArrayList<>();
        resultsNode.elements().forEachRemaining(each -> {
            comicc.add(ComicMapper.toDto(each));
        });

        return comicc;
    }

    private static ComicDto toDto(JsonNode comicNode) {
        if (comicNode == null) {
            throw new IllegalArgumentException("El nodo json no puede ser null");
        }

        ThumbnailDto thumbnailDto = ThumbnailMapper.toDto(comicNode.get("thumbnail"));

        return new ComicDto(
                Long.parseLong(comicNode.get("id").asText()),
                comicNode.get("title").asText(),
                comicNode.get("description").asText(),
                comicNode.get("modified").asText(),
                comicNode.get("resourceURI").asText(),
                thumbnailDto
        );
    }

    private static ArrayNode getResultsNode(JsonNode rootNode) {
        if (rootNode == null) {
            throw new IllegalArgumentException("El nodo json no puede ser null");
        }
        JsonNode dataNode = rootNode.get("data");
        return (ArrayNode) dataNode.get("results");
    }
}
