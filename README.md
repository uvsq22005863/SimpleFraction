# SimpleFraction
# TD 1
## Remarques préliminaires
* Pour l'ensemble des TDs, vous créerez un compte individuel sur [github](https://github.com/).
Vous nommerez ce compte de la façon suivante: `uvsq<MonNuméroÉtudiant>`.
Par exemple, pour un étudiant de numéro *21601234*, le compte sera `uvsq21601234`.
* Les commandes `git` sont à taper en ligne de commande dans un *shell*.
* Vous pouvez utiliser l'IDE de votre choix.
Sur le cartable numérique, [Eclipse](www.eclipse.org), [IntelliJ IDEA](http://www.jetbrains.com/idea/) et [Visual Studio Code](https://code.visualstudio.com/) sont installés.
* Vous répondrez aux questions directement dans ce fichier en complétant les emplacements correspondants
* Vous déposerez une archive contenant l'ensemble de votre travail sur Moodle.

## Partie en présentiel : découverte de `git`
Dans cet exercice, vous créerez une classe `Fraction` représentant un nombre rationnel et une classe `Main` qui testera les méthodes de la classe `Fraction` **avec des assertions**.
À chaque étape, consultez le statut des fichiers du projet ainsi que l'historique.

1. Sur la forge, créez le projet Java `SimpleFraction`;
En terme de *commits*, quelle différence constatez-vous entre cocher une (ou plusieurs) des cases *Initialize this repository with* et n'en cocher aucune ?
    > POUR CHAQUE CASE COCHEE, ON CREE UN COMMIT SUR LA BRANCHE PRINCIPALE SINON LE DEPOT SERA VIDE C'EST A DIRE AUCUN COMMIT.

    Pour la suite, ne cochez aucune de ces cases.
1. Localement, configurez `git` avec votre nom (`user.name`) et votre email (`user.email`);
    ```bash
    git config --global user.name "othmane"
    git config --global user.email "othmane.beloubad@ens.uvsq.fr"
    ```
1. Initialisez le dépôt `git` local pour le projet;
    ```bash
    mkdir TD
    cd TD
    git init
    git remote add origin https://github.com/uvsq22005863/SimpleFraction.git
    ```
1. Créez la classe `Fraction` (vide pour le moment) et la classe `Main` (avec un simple affichage) dans le projet;
Vérifiez que le projet compile et s'exécute dans l'IDE;
Validez les changements;
    ```bash
    public static void main(String[] args){
        System.out.print("Bonjour");
    }

    Sur l'IDE ==> clique droit ("Run)
    Sur le terminal javac Main.java ==> java Main
    ```
1. Ajoutez un constructeur et la méthode `toString` à la classe `Fraction` et modifiez la classe `Main` en conséquence;
Validez les changements;
    ```Java
    public static void main(String[] args){
        Fraction F = new Fraction(3,5);
        System.out.print(F.toString());
    }
    ```
1. Publiez vos modifications sur le dépôt distant;
Vous utiliserez le protocole `https` pour cela;
Vérifiez avec le navigateur;
    ```bash
    git add .
    git commit -m "first commit"
    git push origin master
    ```
1. Sur la forge, ajoutez un fichier de documentation `README.md`.
Quelle syntaxe est utilisée pour ce fichier ?
    > Add file ==> Create new file ==> Commit new file
1. Récupérez localement les modifications effectuées sur la forge.
    ```bash
    git pull origin master
    ```
1. Ajoutez les répertoires et fichiers issus de la compilation aux fichiers ignorés par `git` (fichier `.gitignore`);
    ```bash
    touch .gitignore ==> ON INSERE TOUT CE QU'ON NE VEUT PLUS AFFICHER

    /bin/
    
    ```
1. Retirez les fichiers de configuration de l'IDE du projet;
    ```bash
    ```
    Ajoutez-les aux fichiers ignorés par `git`.
    ```bash
    .gradle
    build
    .idea
    *.class
    *.jar
    *.war
    *.ear
    .DS_Store
    ```
1. Configurez l'accès par clé publique/clé privée à la forge (cf. [Use the SSH protocol with Bitbucket Cloud](https://confluence.atlassian.com/bitbucket/use-the-ssh-protocol-with-bitbucket-cloud-221449711.html)).
    > 1/ NOUS ALLONS GENERER 2 CLES GRACE AUX COMMANDES SUR LE TERMINAL (PUBLIQUE & PRIVEE) QUE NOUS ALLONS STOCKER DANS UN FICHIER
    ENSUITE NOUS ALLONS LES PROTEGER PAR UNE PHRASE SECRETE.

    > 2/ SUR GITHUB, DANS LES PARAMETRES, NOUS ALLONS CREER UNE NOUVELLE CLE SSH, LA NOMEE ET ENFIN COPIER LE CHEMIN D'ACCES QUI NOUS ENMENE VERS LE FICHIER DE LA CLE PUBLIQUE QUE NOUS AVONS CREE.


## Partie en distanciel : révisions et perfectionnement *shell* et *IDE*
### Maîtriser le *shell* de commandes
L'objectif de cet exercice est de vous faire réviser/découvrir les commandes de base du *shell* de votre machine.
Vous pouvez répondre en utilisant le shell de votre choix (*bash*, *Powershell*, ...).
Pour répondre à ces questions, vous devez effectuer les recherches documentaires adéquates (livre, web, ...).

1. Quel OS et quel shell de commande utilisez-vous ?
    > MacOS // Terminal: bash
1. Quelle commande permet d'obtenir de l'aide ?
Donnez un exemple.
    ```bash
        help
    ```
1. Donnez la ou les commandes shell permettant de
    1. afficher les fichiers d'un répertoire triés par taille (taille affichée lisiblement)
        ```bash
        ls -s
        ```
    1. compter le nombre de ligne d'un fichier
        ```bash
        wc -l "fichier"
        ```
    1. afficher les lignes du fichier `Main.java` contenant la chaîne `uneVariable`
        ```bash
         grep "chaine" Main.java -n
        ```
    1. afficher récursivement les fichiers `.java` contenant la chaîne `uneVariable`
        ```bash
         grep "chaine" *.java -n
        ```
    1. trouver les fichiers (pas les répertoires) nommés `README.md` dans une arborescence de répertoires
        ```bash
        find . -name README.md
        ```
    1. afficher les différences entre deux fichiers textes
        ```bash
        diff -y fichier1.txt fichier2.txt
        ```
1. Expliquez en une ou deux phrases le rôle de ces commandes et dans quel contexte elles peuvent être utiles pour un développeur.
    * `ssh`
        > TRANSFERER UN FICHIER OU PLUSIEURS FICHIERS VERS UN SERVEUR EN TOUTE SECURITE
    * `screen`/`tmux`
        > UTILISER PLUSIEURS TERMINAUX DANS UNE SEULE FENETRE
    * `curl`/[HTTPie](https://httpie.org/)
        > PERMETTENT LE DEBOQAGE, INTERACTIONS AVEC LES SERVEURS HTTP, API ...
    * [jq](https://stedolan.github.io/jq/)
        > PERMET DE FILTRER, TRANSFORMER, CONVERTIR DES STRUCTURES DE DONNEES

### Découverte de votre *IDE*
Dans cet exercice, vous expliquerez en quelques phrases comment vous réalisez les actions ci-dessous dans votre IDE.
Vous pouvez choisir l'IDE/éditeur de texte de votre choix.
Pour réaliser cette exercice, vous devez bien évidemment vous reporter à la documentations de l'IDE ([IntelliJ IDEA](https://www.jetbrains.com/help/idea/discover-intellij-idea.html#developer-tools), [Visual Studio Code](https://code.visualstudio.com/docs), [Eclipse](https://help.eclipse.org/2020-09/index.jsp), ...).

1. Quels IDE ou éditeurs de texte utilisez-vous pour le développement Java ?
    > IntelliJ IDEA

    Pour la suite, ne considérez que l'un de vos choix.
1. Comment vérifier/définir que l'encodage utilisé est *UTF-8* ?
    > SUR L'IDE, EN BAS A DROITE, ON CONSTATE LE TYPE D'ENCODAGE UTILISE
    > SINON "PREFERENCES" => "EDITOR" => "CODE STYLE" => "FILE ENCODINGS"
1. Comment choisir le JDK à utiliser dans un projet ?
    > LORS DE LA CREATION DU PROJET => CHOISIR LE JDK SOUHAITEE
1. Comment préciser la version Java des sources dans un projet ?
    > LORS DE LA CREATION DU PROJET => CHOISIR LA VERSION DE JAVA SOUHAITEE
    > SINON CLIQUE DROIT SUR LE PROJET => Add Frameworks Support => SELECTIONNER LA VERSION DE JAVA
1. Comment ajouter une bibliothèque externe dans un projet ?
    > Préferences => Languages & Frameworks => JavaScript => Libraries => Ajouter une bibliotheque
    > SINON File > Project Settings > Libraries > Ajouter une bibliotheque
1. Comment reformater un fichier source Java ?
    > CLIQUE DROIT SUR LE PROJET => Reformat Code
1. Comment trouver la déclaration d'une variable ou méthode ?
    > CTRL-Click sur la variable ou la méthode
1. Comment insérer un bloc de code prédéfini (*snippet*) ?
    > COPIER => COLLER
1. Comment renommer une classe dans l'ensemble du projet ?
    > CLIQUE DROIT SUR LA CLASSE => REFACTOR => RENOMMER + CONFIRMER LES MODIFICATIONS SUR TOUT LE PROJET
1. Comment exécuter le programme en lui passant un paramètre en ligne de commande ?
    > CLIQUER SUR LE BOUTON RUN (COMPILATION + EXECUTION)
1. Comment déboguer le programme en visualisant le contenu d'une ou plusieurs variables ?
    > CLIQUER SUR LA CROIX D'ERREUR => MODIFICATIONS
    > CLIQUER SUR RUN => Debug / Debugging actions
1. Quels paramètres ou fonctionnalités vous semblent particulièrement importants/utiles pour le développement Java ?
    > Manipulation de git (creation, transfert, modifications...)
    > Manipulation de l'IDE "IntelliJ IDEA" (création et parcours du projet, recherches des differentes options...)
