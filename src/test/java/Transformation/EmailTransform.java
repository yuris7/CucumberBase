package Transformation;

    import cucumber.api.Transformer;

/**
 * Created by yurii.voina on 3/16/2017.
 */
public class EmailTransform extends Transformer<String> {

  @Override
  public String transform(String username){
    return username.concat("ea.com");
  }
}
