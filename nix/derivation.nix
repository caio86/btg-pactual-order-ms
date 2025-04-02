{
  jre,
  maven,
  makeWrapper,
}:

maven.buildMavenPackage rec {
  pname = "order-ms";
  version = "0.0.1-SNAPSHOT";

  src = ./..;

  doCheck = false;

  mvnHash = "sha256-I+eW5RhgPPT7Oqu/F4tIE+AsHLLOzQ0tUWmoyON0LJw=";

  nativeBuildInputs = [ makeWrapper ];

  installPhase = ''
    mkdir -p $out/bin $out/share/java
    install -Dm644 target/${pname}.jar $out/share/java

    makeWrapper ${jre}/bin/java $out/bin/${pname} \
      --add-flags "-jar $out/share/java/${pname}.jar"
  '';
}
