package star.wars

import com.fasterxml.jackson.databind.ObjectMapper
import star.wars.model.api.CharacterDescription
import star.wars.model.api.Response

trait Result {
    def getCharacterOne() {
        new ObjectMapper().readValue(new File("src/test/resources/character.json"), CharacterDescription.class).toString()
    }

    def getCharacterList() {
        new ObjectMapper().readValue(new File("src/test/resources/character-list.json"), Response.class).toString()
    }
}