package dave.rulesengine;

public class EvalContext {
    private final Facts facts;

    public EvalContext(Facts facts) {
        this.facts = facts;
    }

    public Object getFact(String key){return facts.get(key);}
    public Facts getfact (){
        return facts;
    }

}
