{
  inputs = {
    nixpkgs.url = "nixpkgs/nixos-unstable";

    flake-parts.url = "github:hercules-ci/flake-parts";
  };

  outputs =
    { self, flake-parts, ... }@inputs:
    flake-parts.lib.mkFlake { inherit inputs; } {
      systems = [
        "x86_64-linux"
        "aarch64-linux"
      ];
      perSystem =
        {
          config,
          self',
          inputs',
          pkgs,
          system,
          ...

        }:
        {
          _module.args.pkgs = import inputs.nixpkgs {
            inherit system;
            overlays = [ self.overlays.default ];
          };

          devShells = {
            default = pkgs.mkShell {
              packages = with pkgs; [
                gcc
                jdk
                maven
                ncurses
                patchelf
                zlib
              ];

              shellHook =
                let
                  loadLombok = "-javaagent:${pkgs.lombok}/share/java/lombok.jar";
                  prev = "\${JAVA_TOOL_OPTIONS:+ $JAVA_TOOL_OPTIONS}";
                in
                ''
                  export JAVA_TOOL_OPTIONS="${loadLombok}${prev}"
                '';
            };
          };

          packages = {
            order-ms = pkgs.callPackage ./nix/derivation.nix { };
          };

          apps = {
            order-ms = {
              type = "app";
              program = "${self'.packages.order-ms}/bin/order-ms";
            };
          };

        };

      flake =
        let
          javaVersion = 17;
        in
        {
          overlays.default =
            final: prev:
            let
              jdk = prev."jdk${toString javaVersion}";
            in
            {
              inherit jdk;
              maven = prev.maven.override { jdk_headless = jdk; };
              gradle = prev.gradle.override { java = jdk; };
              lombok = prev.lombok.override { inherit jdk; };
            };

        };
    };
}
