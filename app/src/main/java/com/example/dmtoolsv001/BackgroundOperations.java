package com.example.dmtoolsv001;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.Random;

public class BackgroundOperations {
    //Begin Writing Code for BackgroundOperations
    public int[] InternalDiceRoller(int quantity, int size, int[] results){
        int total = 0;

        for(int i = 1; i <= quantity; i++){
                int roll = new Random().nextInt(size)+1;
                total += roll;
                results[i] = roll;
            }
        results[0] = total;
        return results;
    }

    public String[] InternalRandomSpell(int level, String school, String AvailableClasses){
        String[] ResultArray = {};
        String[][] SpellsListAll = {
                /*Cantrips*/{"Acid Splash", "Blade Ward", "Booming Blade", "Chill Touch", "Control Flames", "Create Bonfire", "Dancing Lights", "Druidcraft", "Eldritch Blast", "Fire Bolt", "Friends", "Frostbite", "Green-Flame Blade", "Guidance", "Gust", "Infestation", "Light", "Lightning Lure", "Mage Hand", "Magic Stone", "Mending", "Message", "Minor Illusion", "Mold Earth", "Poison Spray", "Prestidigitation", "Primal Savagery", "Produce Flame", "Ray of Frost", "Resistance", "Sacred Flame", "Shape Water", "Shillelagh", "Shocking Grasp", "Spare the Dying", "Sword Burst", "Thaumaturgy", "Thorn Whip", "Thunderclap", "Toll the Dead", "True Strike", "Vicious Mockery", "Word of Radiance"},
                /*Lvl 1 Spells*/{"Absorb Elements", "Alarm", "Animal Friendship", "Armor of Agathys", "Arms of Hadar", "Bane", "Beast Bond", "Bless", "Burning Hands", "Catapult", "Cause Fear", "Ceremony", "Chaos Bolt", "Charm Person", "Chromatic Orb", "Color Spray", "Command", "Compelled Duel", "Comprehend Languages", "Create or Destroy Water", "Cure Wounds", "Detect Evil and Good", "Detect Magic", "Detect Poison and Disease", "Disguise Self", "Dissonant Whispers", "Divine Favor", "Earth Tremor", "Ensnaring Strike", "Entangle", "Expeditious Retreat", "Faerie Fire", "False Life", "Feather Fall", "Find Familiar", "Fog", "Cloud", "Goodberry", "Grease", "Guiding Bolt", "Hail of Thorns", "Healing Word", "Hellish Rebuke", "Heroism", "Hex", "Hunter's Mark", "Ice Knife", "Identify", "Illusory Script", "Inflict Wounds", "Jump", "Longstrider", "Mage Armor", "Magic Missile", "Protection from Evil and Good", "Purify Food and Drink", "Ray of Sickness", "Sanctuary", "Searing Smite", "Shield", "Shield of Faith", "Silent Image", "Sleep", "Snare", "Speak with Animals", "Tasha's Hideous Laughter", "Tenser's Floating Disk", "Thunderous Smite", "Thunderwave", "Unseen Servant", "Witch Bolt", "Wrathful Smite", "Zephyr Strike"},
                /*Lvl 2 Spells*/{"Aganazzar's Scorcher", "Aid", "Alter Self", "Animal Messenger", "Arcane Lock", "Augury", "Barkskin", "Beast Sense", "Blindness/Deafness", "Blur", "Branding Smite", "Calm Emotions", "Cloud of Daggers", "Continual Flame", "Cordon of Arrows", "Crown of Madness", "Darkness", "Darkvision", "Detect Thoughts", "Dragon's Breath", "Dust Devil", "Earthbind", "Enhance Ability", "Enlarge/Reduce", "Enthrall", "Find Steed", "Find Traps", "Flame Blade", "Flaming Sphere", "Gentle Repose", "Gust of Wind", "Healing Spirit", "Heat Metal", "Hold Person", "Invisibility", "Knock", "Lesser Restoration", "Levitate", "Locate Animals or Plants", "Locate Object", "Magic Mouth", "Magic Weapon", "Maximilian's Earthen Grasp", "Melf's Acid Arrow", "Mind Spike", "Mirror Image", "Misty Step", "Moonbeam", "Nystul's Magic Aura", "Pass without a Trace", "Phantasmal Force", "Prayer of Healing", "Protection from Poison", "Pyrotechnics", "Ray of Enfeeblement", "Rope Trick", "Scorching Ray", "See Invisibility", "Shadow Blade", "Shatter", "Silence", "Skywrite", "Snilloc's Snowball Swarm", "Spider Climb", "Spike Growth", "Spiritual Weapon", "Suggestion", "Warding Bond", "Warding Wind", "Web", "Zone of Truth"},
                /*Lvl 3 Spells*/{"Animate Dead", "Aura of Vitality", "Beacon of Hope", "Bestow Curse", "Blinding Smite", "Blink", "Call Lightning", "Catnap", "Clairvoyance", "Conjure Animals", "Conjure Barrage", "Counterspell", "Create Food and Water", "Crusader's Mantle", "Daylight", "Dispel Magic", "Elemental Weapon", "Enemies Abound", "Erupting Earth", "Fear", "Feign Death", "Fireball", "Flame Arrows", "Fly", "Gaseous Form", "Glyph of Warding", "Haste", "Hunger of Hadar", "Hypnotic Pattern", "Leomund's Tiny Hut", "Life Transference", "Lightning Arrow", "Lightning Bolt", "Magic Circle", "Major Image", "Mass Healing Word", "Meld into Stone", "Melf's Minute Meteors", "Nondetection", "Phantom Steed", "Plant Growth", "Protection from Energy", "Remove Curse", "Revivify", "Sending", "Sleet Storm", "Slow", "Speak with Dead", "Speak with Plants", "Spirit Guardians", "Stinking Cloud", "Summon Lesser Demons", "Thunder Step", "Tidal Wave", "Tiny Servant", "Tongues", "Vampiric Touch", "Wall of Sand", "Wall of Water", "Water Breathing", "Water Walk", "Wind Wall"},
                /*Lvl 4 Spells*/{"Arcane Eye", "Aura of Life", "Aura of Purity", "Banishment", "Blight", "Charm Monster", "Compulsion", "Confusion", "Conjure Minor Elementals", "Conjure Woodland Beings", "Control Water", "Death Ward", "Dimension Door", "Divination", "Dominate Beast", "Elemental Bane", "Evard's Black Tentacles", "Fabricate", "Find Greater Steed", "Fire Shield", "Freedom of Movement", "Giant Insect", "Grasping Vine", "Greater Invisibility", "Guardian of Faith", "Guardian of Nature", "Hallucinatory Terrain", "Ice Storm", "Leomund's Secret Chest", "Locate Creature", "Mordenkainen's Faithful Hound", "Mordenkainen's Private Sanctum", "Otiluke's Resilient Sphere", "Phantasmal Killer", "Polymorph", "Shadow of Moil", "Sickening Radiance", "Staggering Smite", "Stone Shape", "Stoneskin", "Storm Sphere", "Summon Greater Demon", "Vitriolic Sphere", "Wall of Fire", "Watery Sphere"},
                /*Lvl 5 Spells*/{"Animate Objects", "Antilife Shell", "Awaken", "Banishing Smite", "Bigby's Hand", "Circle of Power", "Cloudkill", "Commune", "Commune with Nature", "Cone of Cold", "Conjure Elemental", "Conjure Volley", "Contact Other Plane", "Contagion", "Control Winds", "Creation", "Danse Macabre", "Dawn", "Destructive Wave", "Dispel Evil and Good", "Dominate Person", "Dream", "Enervation", "Far Step", "Flame Strike", "Geas", "Greater Restoration", "Hallow", "Hold Monster", "Holy Weapon", "Immolation", "Infernal Calling", "Insect Plague", "Legend Lore", "Maelstrom", "Mass Cure Wounds", "Mislead", "Modify Memory", "Negative Energy Flood", "Passwall", "Planar Binding", "Raise Dead", "Rary's Telepathic Bond", "Reincarnate", "Scrying", "Seeming", "Skill Empowerment", "Steel Wind Strike", "Swift Quiver", "Synaptic Static", "Telekinesis", "Teleportation Circle", "Transmute Rock", "Tree Stride", "Wall of Force", "Wall of Light", "Wall of Stone", "Wrath of Nature"},
                /*Lvl 6 Spells*/{"Arcane Gate", "Blade Barrier", "Bones of the Earth", "Chain Lightning", "Circle of Death", "Conjure Fey", "Contingency", "Create Homunculus", "Create Undead", "Disintegrate", "Drawmij's Instant Summons", "Druid Grove", "Eyebite", "Find the Path", "Flesh to Stone", "Forbiddance", "Globe of Invulnerability", "Guards and Wards", "Harm", "Heal", "Heroes' Feast", "Investiture of Flame", "Investiture of Ice", "Investiture of Stone", "Investiture of Wind", "Magic Jar", "Mass Suggestion", "Mental Prison", "Move Earth", "Otiluke's Freezing Sphere", "Otto's Irresistible Dance", "Planar Ally", "Primordial Ward", "Programmed Illusion", "Scatter", "Soul Cage", "Sunbeam", "Tenser's Transformation", "Transport via Plants", "True Sing", "Wall of Ice", "Wall of Thorns", "Wind Walk", "Word of Recall"},
                /*Lvl 7 Spells*/{"Conjure Celestial", "Crown of Stars", "Delayed Blast Fireball", "Divine Word", "Etherealness", "Finger of Death", "Fire Storm", "Forcecage", "Mirage Arcane", "Mordenkainen's Magnificent Mansion", "Mordenkainen's Sword", "Plane Shift", "Power Word Pain", "Prismatic Spray", "Project Image", "Regenerate", "Resurrection", "Reverse Gravity", "Sequester", "Simulacrum", "Symbol", "Teleport", "Temple of the Gods", "Whirlwind"},
                /*Lvl 8 Spells*/{"Abi-Dalzim's Horrid Wilting", "Animal Shapes", "Antimagic Field", "Antipathy/Sympathy", "Clone", "Control Weather", "Demiplane", "Dominate Monster", "Earthquake", "Feeblemind", "Glibness", "Holy Aura", "Illusory Dragon", "Incendiary Cloud", "Maddening Darkness", "Maze", "Mighty Fortress", "Mind Blank", "Power Word Stun", "Sunburst", "Telepathy", "Tsunami"},
                /*Lvl 9 Spells*/{"Astral Projection", "Foresight", "Gate", "Imprisonment", "Invulnerability", "Mass Heal", "Mass Polymorph", "Meteor Swarm", "Power Word Heal", "Power Word Kill", "Prismatic Wall", "Psychic Scream", "Shapechange", "Storm of Vengeance", "Time Stop", "True Polymorph", "True Resurrection", "Weird", "Wish"}
        };
        return ResultArray;



    };






    //End BackgroundOperations Code
}
