public class Pokemon {
    private final int damage;
    private final String element;
    private final String name;

    public Pokemon(String name, String element, int damage){
        this.damage = damage;
        this.element = element;
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name + "\n" +
                this.element + "\n" +
                this.damage + "\n";
    }

    @Override
    public boolean equals(Object other){
        if (other == null || getClass() != other.getClass()){
            return false;
        }
        Pokemon otherPokemon = (Pokemon) other;
        return this.damage ==  otherPokemon.damage &&
                this.element.equals(otherPokemon.element) &&
                this.name.equals(otherPokemon.name);

    }
}
