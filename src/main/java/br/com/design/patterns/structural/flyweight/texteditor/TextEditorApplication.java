package br.com.design.patterns.structural.flyweight.texteditor;

import java.util.HashMap;
import java.util.Map;

public class TextEditorApplication {
    public static void main(String[] args) {
        String text = "Hello, World!";
        // For each character, we fetch the shared Glyph and then "draw" it at the given position
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            Glyph glyph = GlyphFactory.getGlyph(c);
            glyph.draw(i);
        }
    }
}

// The Flyweight class representing a character
class Glyph {
    private char character;

    public Glyph(char character) {
        this.character = character;
    }

    public void draw(int position) {
        System.out.println("Drawing character '" + character + "' at position " + position);
    }
}

// The Flyweight factory that caches Glyph objects
class GlyphFactory {
    private static Map<Character, Glyph> glyphs = new HashMap<>();

    public static Glyph getGlyph(char character) {
        Glyph glyph = glyphs.get(character);
        if(glyph == null) {
            glyph = new Glyph(character);
            glyphs.put(character, glyph);
        }
        return glyph;
    }
}